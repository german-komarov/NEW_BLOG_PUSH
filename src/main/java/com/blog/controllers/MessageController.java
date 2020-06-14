package com.blog.controllers;


import com.blog.entities.Message;
import com.blog.entities.Users;
import com.blog.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/main/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    //All messages
    @GetMapping
    public String allMessages(@AuthenticationPrincipal Users users, Model model)
    {

        //adding attributes
        model.addAttribute("newCounter",messageService.getNewMessages(users.getUsername()).size());
        model.addAttribute("newList",messageService.getNewMessages(users.getUsername()));
        model.addAttribute("checkedList",messageService.getCheckedMessages(users.getUsername()));

        return "messages";
    }

    //Read new message
    @GetMapping(value="/readNewMessage/{id}")
    public String readNewMessage(@AuthenticationPrincipal Users users,@PathVariable(name="id") long id, Model model)
    {
        Message message=messageService.getOneMessage(id);

        if (!message.getReceiver().equals(users.getUsername()))
        {
            return "denied_page";
        }

        message.setSource("checked");
        messageService.save(message);
        model.addAttribute("message",message);
        return "read_message";
    }


    //Read checked message
    @GetMapping("/readCheckedMessage/{id}")
    public String readCheckedMessage(@AuthenticationPrincipal Users users,Model model, @PathVariable(name="id") long id)
    {
        Message message=messageService.getOneMessage(id);
        if (!message.getReceiver().equals(users.getUsername()))
        {
            return "denied_page";
        }
        model.addAttribute("message",message);
        return "read_message";
    }


    //Read sent message
    @GetMapping("/readSentMessage/{id}")
    public String readSentMessages(@AuthenticationPrincipal Users users,Model model,@PathVariable(name="id") long id)
    {
        Message message=messageService.getOneMessage(id);
        if (!message.getSender().equals(users.getUsername()))
        {
            return "denied_page";
        }
        model.addAttribute("message",message);
        return "read_sent_message";
    }


    //Read deleted message
    @GetMapping("/readDeletedMessage/{id}")
    public String readDeletedMessage(@AuthenticationPrincipal Users users,Model model, @PathVariable(name="id") long id)
    {
        Message message=messageService.getOneMessage(id);
        if (!(message.getReceiver().equals(users.getUsername()) || message.getSender().equals(users.getUsername())))
        {
            return "denied_page";
        }

        model.addAttribute("message",message);
        model.addAttribute("new","new");
        model.addAttribute("sent","sent");
        model.addAttribute("checked","checked");
        return "read_deleted_message";
    }


    @GetMapping("/writeMessage")
    public String getWrite(@AuthenticationPrincipal Users users,Model model)
    {
        Message message=new Message();
        message.setSender(users.getUsername());
        message.setSubject("No subject");
        message.setSource("new");
        message.setDeletedByReceiver((short) 0);
        message.setDeletedBySender((short)0);
        model.addAttribute("message",message);
        return "write_message";

    }

    @PostMapping(value="/writeMessage/send")
    public String postWrite(@ModelAttribute("sentMessage") Message message)
    {
        messageService.save(message);
        return "redirect:/main/message";
    }

    @GetMapping("/sentMessage")
    public String allSentMessages(@AuthenticationPrincipal Users users,Model model)
    {

        model.addAttribute("sentList",messageService.getSentMessages(users.getUsername()));
        return "sent_messages_list";

    }


    @GetMapping("/deletedMessage")
    public String allDeletedMessages(@AuthenticationPrincipal Users users,Model model)
    {

        model.addAttribute("deletedNewMessagesList",messageService.getDeletedNewMessages(users.getUsername()));
        model.addAttribute("deletedCheckedMessagesList",messageService.getDeletedCheckedMessages(users.getUsername()));
        model.addAttribute("deletedSentMessagesList",messageService.getDeletedSentMessages(users.getUsername()));
        return "deleted_messages_list";
    }


    @GetMapping("/answer/{sender}")
    public String getAnswer(@AuthenticationPrincipal Users users,Model model,@PathVariable(name="sender") String sender)
    {
        Message message=new Message();
        message.setSender(users.getUsername());
        message.setReceiver(sender);
        message.setSubject("No subject");
        message.setSource("new");
        message.setDeletedByReceiver((short) 0);
        message.setDeletedBySender((short)0);
        model.addAttribute("message",message);
        return "answer_message";
    }

    @GetMapping("/delete/{id}")
    public String deleteMessage(@AuthenticationPrincipal Users users,@PathVariable ("id") Long id)
    {
        Message message=messageService.getOneMessage(id);
        if(message.getSender().equals(users.getUsername()))
        {
            message.setDeletedBySender((short) 1);
            messageService.save(message);
            return "redirect:/main/message/sentMessage";
        }

        else if(message.getReceiver().equals(users.getUsername()))
        {
            message.setDeletedByReceiver((short)1);
            messageService.save(message);
            return "redirect:/main/message";
        }

        else
        {
            return "denied_page";
        }
    }

    @GetMapping("/restoreMessage/{id}")
    public String restoreMessage(@AuthenticationPrincipal Users users,@PathVariable("id") Long id)
    {
        Message message=messageService.getOneMessage(id);
        if(message.getSender().equals(users.getUsername()))
        {
            message.setDeletedBySender((short) 0);
            messageService.save(message);
            return "redirect:/main/message/deletedMessage";
        }
        else if(message.getReceiver().equals(users.getUsername()))
        {
            message.setDeletedByReceiver((short) 0);
            messageService.save(message);
            return "redirect:/main/message/deletedMessage";
        }

        else
        {
            return "denied_page";
        }
    }

    @GetMapping("/delete/areYouSureDelete/{id}")
    public String areYouSureDelete(@AuthenticationPrincipal Users users,@PathVariable(name="id") long id,Model model)
    {
        Message message=messageService.getOneMessage(id);
        if(!(message.getSender().equals(users.getUsername()) || message.getReceiver().equals(users.getUsername())))
        {
            return "denied_page";
        }
        model.addAttribute("id",id);
        return "are_you_sure_delete";

    }

    @GetMapping("/delete/deleteAtAll/{id}")
    public String deleteAtAll(@AuthenticationPrincipal Users users, @PathVariable(name="id") long id)
    {
        Message message=messageService.getOneMessage(id);
        if(message.getSender().equals(users.getUsername()))
        {
            if(message.getDeletedByReceiver()!=(short)2) {
                message.setDeletedBySender((short) 2);
                messageService.save(message);
            }
            else
            {
                messageService.delete(id);
            }
            return "redirect:/main/message/deletedMessage";
        }

        else if(message.getReceiver().equals(users.getUsername()))
        {
            if(message.getDeletedBySender()!=(short)2)
            {
                message.setDeletedByReceiver((short) 2);
                messageService.save(message);
            }
            else
            {
                messageService.delete(id);
            }
            return "redirect:/main/message/deletedMessage";

        }

        else
        {
            return "denied_page";
        }


    }




    @GetMapping("/delete/areYouSureDeleteFromBoth/{id}")
    public String areYouSureDeleteFromBoth(@AuthenticationPrincipal Users users,@PathVariable(name="id") long id,Model model)
    {

        if(!messageService.getOneMessage(id).getSender().equals(users.getUsername()))
        {
            return "denied_page";
        }
        model.addAttribute("id",id);
        return "are_you_sure_delete_from_both";
    }

    @GetMapping("/delete/deleteAtAllFromBoth/{id}")
    public String deleteAtAllFromBoth(@AuthenticationPrincipal Users users,@PathVariable(name="id") long id)
    {

        Message message=messageService.getOneMessage(id);

        if(message.getSender().equals(users.getUsername()))
        {
            messageService.delete(id);
            return "redirect:/main/message/deletedMessage";
        }

        else
        {
            return "denied_page";
        }



    }






















}

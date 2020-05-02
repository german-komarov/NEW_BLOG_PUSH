package com.blog.controllers;


import com.blog.entities.Users;
import com.blog.entities.message.CheckedMessage;
import com.blog.entities.message.DeletedMessage;
import com.blog.entities.message.NewMessage;
import com.blog.entities.message.SentMessage;
import com.blog.services.messageServices.CheckedMessageService;
import com.blog.services.messageServices.DeletedMessageService;
import com.blog.services.messageServices.NewMessageService;
import com.blog.services.messageServices.SentMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MessageController {
    @Autowired
    private CheckedMessageService checkedMessageService;

    @Autowired
    private DeletedMessageService deletedMessageService;

    @Autowired
    private NewMessageService newMessageService;

    @Autowired
    private SentMessageService sentMessageService;


    //All messages
    @GetMapping("/main/message")
    public String allMessages(Model model)
    {
        //get current user
        Users users = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //new messages
        List<NewMessage> newMessageList=newMessageService.newMessagesList(users.getUsername());
        //checked messages
        List<CheckedMessage> checkedMessageList=checkedMessageService.checkedMessagesList(users.getUsername());
        //adding attributes
        model.addAttribute("newCounter",newMessageList.size());
        model.addAttribute("newList",newMessageList);
        model.addAttribute("checkedList",checkedMessageList);

        return "messages";
    }

    //Read checked messages
    @GetMapping("/main/message/readCheckedMessage/{id}")
    public String readCheckedMessage(Model model, @PathVariable(name="id") long id)
    {
        //get current user
        Users users = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!checkedMessageService.get(id).getReceiver().equals(users.getUsername()))
        {
            return "denied_page";
        }
        CheckedMessage checkedMessage=checkedMessageService.checkedMessage(users.getUsername(),id);
        model.addAttribute("message",checkedMessage);
        return "read_message";
    }

    //Read deleted messages
    @GetMapping("/main/message/readDeletedMessage/{id}")
    public String readDeletedMessage(Model model, @PathVariable(name="id") long id)
    {
        //get current user
        Users users = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!deletedMessageService.get(id).getDeleter().equals(users.getUsername()))
        {
            return "denied_page";
        }
        DeletedMessage deletedMessage=deletedMessageService.deletedMessage(users.getUsername(),id);
        model.addAttribute("message",deletedMessage);
        model.addAttribute("new","NewMessage");
        model.addAttribute("sent","SentMessage");
        model.addAttribute("check","CheckedMessage");
        return "read_deleted_message";
    }

    //Read new message
    @GetMapping(value="/main/message/readNewMessage/{id}")
    public String readNewMessage(@PathVariable(name="id") long id, Model model)
    {
        //get current user
        Users users = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!newMessageService.get(id).getReceiver().equals(users.getUsername()))
        {
            return "denied_page";
        }
        NewMessage newMessage=newMessageService.newMessage(users.getUsername(),id);

        CheckedMessage checkedMessage=new CheckedMessage();
        checkedMessage.setSubject(newMessage.getSubject());
        checkedMessage.setContent(newMessage.getContent());
        checkedMessage.setReceivedAt(newMessage.getReceivedAt());
        checkedMessage.setReceiver(newMessage.getReceiver());
        checkedMessage.setSender(newMessage.getSender());
        checkedMessage.setSent_id(newMessage.getSent_id());
        checkedMessageService.save(checkedMessage);
        model.addAttribute("message",newMessage);
        newMessageService.delete(newMessage.getId());
        return "read_new_message";
    }


    @GetMapping("/main/message/writeMessage")
    public String getWrite(Model model)
    {
        Users users = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SentMessage sentMessage=new SentMessage();
        sentMessage.setSender(users.getUsername());
        sentMessage.setSubject("No subject");
        model.addAttribute("sentMessage",sentMessage);
        return "write_message";

    }

    @PostMapping(value="/main/message/writeMessage/send")
    public String postWrite(@ModelAttribute("sentMessage") SentMessage sentMessage)
    {
        NewMessage newMessage=new NewMessage();
        newMessage.setContent(sentMessage.getContent());
        newMessage.setReceiver(sentMessage.getReceiver());
        newMessage.setSender(sentMessage.getSender());
        newMessage.setSubject(sentMessage.getSubject());
        sentMessageService.save(sentMessage);
        newMessage.setSent_id(sentMessage.getId());
        newMessageService.save(newMessage);

        return "successfully_sent_message";

    }


    @GetMapping("/main/message/sentMessage")
    public String allSentMessages(Model model)
    {
        Users users = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<SentMessage> sentMessageList=sentMessageService.sentMessagesList(users.getUsername());
        model.addAttribute("sentList",sentMessageList);
        return "sent_messages_list";

    }

    @GetMapping("/main/message/deleteMessage")
    public String allDeletedMessages(Model model)
    {
        Users users = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<DeletedMessage> deletedNewMessagesList=deletedMessageService.deletedNewMessagesList(users.getUsername());
        model.addAttribute("deletedNewMessagesList",deletedNewMessagesList);
        List<DeletedMessage> deletedCheckedMessagesList=deletedMessageService.deletedCheckedMessagesList(users.getUsername());
        model.addAttribute("deletedCheckedMessagesList",deletedCheckedMessagesList);
        List<DeletedMessage> deletedSentMessagesList=deletedMessageService.deletedSentMessagesList(users.getUsername());
        model.addAttribute("deletedSentMessagesList",deletedSentMessagesList);
        return "deleted_messages_list";

    }

    @GetMapping("/main/message/delete/deleteAtAll/{id}")
    public String deleteAtAll(@PathVariable(name="id") long id)
    {
        Users users = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!deletedMessageService.get(id).getDeleter().equals(users.getUsername()))
        {
            return "denied_page";
        }
        deletedMessageService.delete(id);
        return "deleted_successful";
    }



    @GetMapping("/main/message/readSentMessage/{id}")
    public String readSentMessages(Model model,@PathVariable(name="id") long id)
    {
        //get current user
        Users users = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!sentMessageService.get(id).getSender().equals(users.getUsername()))
        {
            return "denied_page";
        }
        SentMessage sentMessage=sentMessageService.sentMessage(users.getUsername(),id);
        model.addAttribute("message",sentMessage);
        return "read_sent_message";
    }

    @GetMapping("/main/message/answer/{sender}")
    public String getAnswer(Model model,@PathVariable(name="sender") String sender)
    {
        Users users = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SentMessage sentMessage=new SentMessage();
        sentMessage.setSender(users.getUsername());
        sentMessage.setReceiver(sender);
        sentMessage.setSubject("No subject");
        model.addAttribute("sentMessage",sentMessage);
        return "answer_message";

    }


    @GetMapping("/main/message/delete/NewMessage/{id}")
    public String deleteNew(@PathVariable(name="id") long id)
    {
        Users users = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        NewMessage newMessage=newMessageService.get(id);
        if(!newMessage.getReceiver().equals(users.getUsername()))
        {
            return "denied_page";
        }
        DeletedMessage deletedMessage=new DeletedMessage();
        deletedMessage.setContent(newMessage.getContent());
        deletedMessage.setDeletedFrom(newMessage.getSource());
        deletedMessage.setOriginalTime(newMessage.getReceivedAt());
        deletedMessage.setReceiver(newMessage.getReceiver());
        deletedMessage.setSender(newMessage.getSender());
        deletedMessage.setSubject(newMessage.getSubject());
        deletedMessage.setDeleter(users.getUsername());
        deletedMessage.setSent_id(newMessage.getSent_id());
        deletedMessageService.save(deletedMessage);
        newMessageService.delete(id);
        return "redirect:/main/message";

    }

    @GetMapping("/main/message/delete/CheckedMessage/{id}")
    public String deleteChecked(@PathVariable(name="id") long id)
    {
        Users users = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CheckedMessage checkedMessage=checkedMessageService.get(id);
        if(!checkedMessage.getReceiver().equals(users.getUsername()))
        {
            return "denied_page";
        }
        DeletedMessage deletedMessage=new DeletedMessage();
        deletedMessage.setContent(checkedMessage.getContent());
        deletedMessage.setDeletedFrom(checkedMessage.getSource());
        deletedMessage.setOriginalTime(checkedMessage.getReceivedAt());
        deletedMessage.setReceiver(checkedMessage.getReceiver());
        deletedMessage.setSender(checkedMessage.getSender());
        deletedMessage.setSubject(checkedMessage.getSubject());
        deletedMessage.setDeleter(users.getUsername());
        deletedMessage.setSent_id(checkedMessage.getSent_id());
        deletedMessageService.save(deletedMessage);
        checkedMessageService.delete(id);

        return "redirect:/main/message";
    }

    @GetMapping("/main/message/delete/SentMessage/{id}")
    public String deleteSent(@PathVariable(name="id") long id)
    {
        Users users = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SentMessage sentMessage=sentMessageService.get(id);
        if(!sentMessage.getSender().equals(users.getUsername()))
        {
            return "denied_page";
        }
        DeletedMessage deletedMessage=new DeletedMessage();
        deletedMessage.setContent(sentMessage.getContent());
        deletedMessage.setDeletedFrom(sentMessage.getSource());
        deletedMessage.setOriginalTime(sentMessage.getSentAt());
        deletedMessage.setReceiver(sentMessage.getReceiver());
        deletedMessage.setSender(sentMessage.getSender());
        deletedMessage.setSubject(sentMessage.getSubject());
        deletedMessage.setDeleter(users.getUsername());
        deletedMessage.setSent_id(sentMessage.getId());
        deletedMessageService.save(deletedMessage);
        sentMessageService.delete(id);
        return "redirect:/main/message";
    }




    @GetMapping("/main/message/delete/AreYouSureDelete/{id}")
    public String areYouSureDelete(@PathVariable(name="id") long id,Model model)
    {
        Users users = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!deletedMessageService.get(id).getDeleter().equals(users.getUsername()))
        {
            return "denied_page";
        }
        model.addAttribute("id",id);
        return "are_you_sure_delete";

    }



    @GetMapping("/main/message/restoreSentMessage/{id}")
    public String restoreSentMessage(@PathVariable(name="id") long id)
    {
        Users users = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        DeletedMessage deletedMessage=deletedMessageService.get(id);
        if(!deletedMessage.getDeleter().equals(users.getUsername()))
        {
            return "denied_page";
        }
        SentMessage sentMessage=new SentMessage();
        sentMessage.setReceiver(deletedMessage.getReceiver());
        sentMessage.setSubject(deletedMessage.getSubject());
        sentMessage.setSender(deletedMessage.getSender());
        sentMessage.setContent(deletedMessage.getContent());
        //sentMessage.setSentAt(deletedMessage.getOriginalTime());
        sentMessageService.save(sentMessage);
        sentMessage=sentMessageService.get(sentMessage.getId());
        sentMessage.setSentAt(deletedMessage.getOriginalTime());
        sentMessageService.save(sentMessage);

        deletedMessageService.delete(id);
        return "successfully_restored";
    }


    @GetMapping("/main/message/restoreNewMessage/{id}")
    public String restoreNewMessage(@PathVariable(name="id") long id)
    {
        Users users = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        DeletedMessage deletedMessage=deletedMessageService.get(id);
        if(!deletedMessage.getDeleter().equals(users.getUsername()))
        {
            return "denied_page";
        }
        NewMessage newMessage=new NewMessage();
        newMessage.setSent_id(deletedMessage.getSent_id());
        newMessage.setSubject(deletedMessage.getSubject());
        newMessage.setSender(deletedMessage.getSender());
        newMessage.setReceiver(deletedMessage.getReceiver());
        newMessage.setContent(deletedMessage.getContent());
        //newMessage.setReceivedAt(deletedMessage.getOriginalTime());
        newMessageService.save(newMessage);
        newMessage=newMessageService.get(newMessage.getId());
        newMessage.setReceivedAt(deletedMessage.getOriginalTime());
        newMessageService.save(newMessage);
        deletedMessageService.delete(id);
        return "successfully_restored";
    }

    @GetMapping("/main/message/restoreCheckedMessage/{id}")
    public String restoreCheckedMessage(@PathVariable(name="id") long id)
    {
        Users users = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        DeletedMessage deletedMessage=deletedMessageService.get(id);
        if(!deletedMessage.getDeleter().equals(users.getUsername()))
        {
            return "denied_page";
        }

        CheckedMessage checkedMessage=new CheckedMessage();
        checkedMessage.setSent_id(deletedMessage.getSent_id());
        checkedMessage.setSender(deletedMessage.getSender());
        checkedMessage.setReceiver(deletedMessage.getReceiver());
        //checkedMessage.setReceivedAt(deletedMessage.getOriginalTime());
        checkedMessage.setContent(deletedMessage.getContent());
        checkedMessage.setSubject(deletedMessage.getSubject());

        checkedMessageService.save(checkedMessage);
        checkedMessage=checkedMessageService.get(checkedMessage.getId());
        checkedMessage.setReceivedAt(deletedMessage.getOriginalTime());
        checkedMessageService.save(checkedMessage);
        deletedMessageService.delete(id);
        return "successfully_restored";


    }

    @GetMapping("/main/message/delete/AreYouSureDeleteFromBoth/{id}")
    public String areYouSureDeleteFromBoth(@PathVariable(name="id") long id,Model model)
    {
        Users users = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(!sentMessageService.get(id).getSender().equals(users.getUsername()))
        {
            return "denied_page";
        }
        model.addAttribute("id",id);
        return "are_you_sure_delete_from_both";
    }

    @GetMapping("/main/message/delete/deleteAtAllFromBoth/{id}")
    public String deleteAtAllFromBoth(@PathVariable(name="id") long id)
    {
        Users users = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!newMessageService.findBySentid(id).isEmpty())
        {
            if(!newMessageService.findBySentid(id).get(0).getSender().equals(users.getUsername()))
            {
                return "denied_page";
            }
            newMessageService.delete(newMessageService.findBySentid(id).get(0).getId());
            sentMessageService.delete(id);
            return "successfully_deleted_from_both";
        }


        if(!checkedMessageService.findBySentid(id).isEmpty())
        {
            if(!checkedMessageService.findBySentid(id).get(0).getSender().equals(users.getUsername()))
            {
                return "denied_page";
            }
            checkedMessageService.delete(checkedMessageService.findBySentid(id).get(0).getId());
            sentMessageService.delete(id);
            return "successfully_deleted_from_both";
        }

        if (!deletedMessageService.findBySentid(id).isEmpty())
        {
            if(!deletedMessageService.findBySentid(id).get(0).getSender().equals(users.getUsername()))
            {
                return "denied_page";
            }
            deletedMessageService.delete(deletedMessageService.findBySentid(id).get(0).getId());
            sentMessageService.delete(id);
            return "successfully_deleted_from_both";
        }

        if(sentMessageService.get(id).getSender().equals(users.getUsername()))
        {
            sentMessageService.delete(id);
            return "already_deleted";
        }
        else
        {
            return "denied_page";
        }





    }
















}

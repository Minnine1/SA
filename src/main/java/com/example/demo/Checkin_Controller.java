package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;

@Controller
public class Checkin_Controller {

    @RequestMapping(value = "/checkin")
    public String index() {
        return "index";
    }

    @Autowired
    Recrepo record_repo2;

    @Autowired
    Book_ticket_Repository record_repo;



    @ResponseBody
    @RequestMapping(path =  "/cus/{id}/date/{date}",method = RequestMethod.GET)
    public  String rec(@PathVariable String id,@PathVariable String date) throws ParseException {
        Book_ticket book1 = this.record_repo.findOne(id);

       record rec1 = new record(book1,date);
        record_repo2.save(rec1);

        return   "seved";



    }
}

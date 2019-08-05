package org.rummel.kudos.service;


import org.rummel.kudos.entities.Employee;
import org.rummel.kudos.entities.Kudos;
import org.rummel.kudos.entities.Pillar;
import org.rummel.kudos.repositories.KudosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class KudosService {

    @Autowired
    KudosRepository kudosRepository;

    @Autowired
    private JavaMailSender emailSender;

    public void sendKudos(Employee author, Employee recipient, Pillar pillar, String message) {
        Kudos kudos = new Kudos();
        kudos.setAuthor(author);
        kudos.setRecipient(recipient);
        kudos.setPillar(pillar);
        kudos.setMessage(message);


        SimpleMailMessage email = new SimpleMailMessage();
//        email.setTo(recipient.getEmailAddress());
        email.setTo("shawn.rummel@gmail.com");
        email.setSubject("Kudos ");
        email.setText(message);
        emailSender.send(email);


        kudosRepository.save(kudos);
    }

//    public Employee save(Employee employee) {
//       return repository.save(employee);
//    }
}

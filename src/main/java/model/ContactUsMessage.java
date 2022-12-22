package model;

import enums.ContactUsMessageSubject;
import lombok.Data;

@Data
public class ContactUsMessage {
    private ContactUsMessageSubject subject;
    private String emailAddress;
    private String orderReference;
    private String messageText;

}

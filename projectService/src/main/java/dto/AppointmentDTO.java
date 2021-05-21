package dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import model.Client;
import model.Service;
import model.Staff;
import model.User;

import java.time.LocalDateTime;

@Data
public class AppointmentDTO {

    private String id;

    private Staff staff;

    private Client client;

    private Service service;

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime date_from;

    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime date_to;
}

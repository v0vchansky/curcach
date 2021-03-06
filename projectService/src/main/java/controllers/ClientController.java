package controllers;

import dto.ClientDTO;
import lombok.RequiredArgsConstructor;
import mappers.ClientMapper;
import model.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ClientService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientMapper clientMapper;

    private final ClientService clientService;

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getClient(@PathVariable UUID id) {
        Client client = clientService.findById(id);
        return new ResponseEntity<>(clientMapper.toDTO(client), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<ClientDTO>> getClients() {
        List<Client> clients = clientService.findAll();
        return new ResponseEntity<>(clientMapper.listToDTO(clients), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateClient(@PathVariable UUID id, @RequestBody ClientDTO clientDTO) {
        Client client = clientService.findById(id);
        clientService.save(clientMapper.mergeWith(clientDTO, client));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("")
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO) {
        Client client = clientMapper.toEntity(clientDTO);
        Client responseClient = clientService.save(client);
        return new ResponseEntity(clientMapper.toDTO(responseClient), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable UUID id) {
        clientService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}

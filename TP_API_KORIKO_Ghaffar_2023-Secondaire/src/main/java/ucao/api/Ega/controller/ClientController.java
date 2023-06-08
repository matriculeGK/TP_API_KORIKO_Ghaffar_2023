package ucao.api.Ega.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ucao.api.Ega.entity.Client;
import ucao.api.Ega.service.ClientService;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;
    @GetMapping("/clients")
    public List<Client> listeClient(){
        return clientService.showClient();
    }
    @GetMapping("/clients/{id}")
    public Client getClient(@PathVariable Integer id){
        return clientService.getOneClient(id);
    }
    @PostMapping("/clients")
    public Client saveClient(@RequestBody Client client){
        return clientService.saveClient(client);
    }
    @PutMapping("/clents/{id}")
    public Client updateClient(@PathVariable Integer id, @RequestBody Client client){
        client.setId(id);
        return clientService.saveClient(client);
    }
    @DeleteMapping("/clients/{id}")
    public void supprimerClient(@PathVariable Integer id){
        clientService.deleteClient(id);
    }

}

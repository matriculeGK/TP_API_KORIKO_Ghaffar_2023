package ucao.api.Ega.service;

import ucao.api.Ega.entity.Client;

import java.util.List;

public interface ClientService {
    public List<Client> showClient();
    public Client saveClient(Client client);
    public Client getOneClient(Integer id);
    public void deleteClient(Integer id);
}

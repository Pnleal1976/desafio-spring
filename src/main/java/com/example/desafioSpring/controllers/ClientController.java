package com.example.desafioSpring.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.desafioSpring.entities.Client;
import com.example.desafioSpring.entities.House;
import com.example.desafioSpring.entities.Vehicle;
import com.example.desafioSpring.repositories.ClientRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/client")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientController {
    private ClientRepository clientRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client create(@RequestBody @Validated Client client) throws Exception {
        return clientRepository.save(client);
    }

    @GetMapping
    public List<Client> listAll() {
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client findById(@PathVariable Long id) throws Exception {
        return clientRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(
            @RequestBody Client updatedClient,
            @PathVariable(value = "id") Long idClient) {

        Optional<Client> optionalClient = clientRepository.findById(idClient);

        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            // Atualizar os campos do cliente
            BeanUtils.copyProperties(updatedClient, client, "idClient");
            // Atualizar veículos
            if (updatedClient.getListVehicles() != null) {
                for (Vehicle vehicle : updatedClient.getListVehicles()) {
                    vehicle.setClient_idClient(client);
                    vehicle.setVehicleUpdateInfo(LocalDate.now());
                }
            }
            // Atualizar casas
            if (updatedClient.getListHouses() != null) {
                for (House house : updatedClient.getListHouses()) {
                    house.setClient_idClient(client);
                    house.setHouseUpdateInfo(LocalDate.now());
                }
            }
            client.setUdateInfoClient(LocalDate.now());
            clientRepository.save(client);
            return new ResponseEntity<>(client, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

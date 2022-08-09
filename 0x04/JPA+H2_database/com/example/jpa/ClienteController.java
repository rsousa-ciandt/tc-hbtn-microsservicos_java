package com.example.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class ClienteController {
    private final Logger LOGGER = Logger.getLogger(Cliente.class.getName());

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @PostMapping("/addClient")
    public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) {

        cliente.getEnderecos().forEach(endereco -> endereco.setCliente(cliente));

        cliente.getTelefones().forEach(telefone -> telefone.setCliente(cliente));

        Cliente clientSaved = this.clienteRepository.save(cliente);

        return ResponseEntity.ok(clientSaved);
    }

    @GetMapping("/findAllClients")
    public ResponseEntity<List<Cliente>> findAllClients() {
        List<Cliente> clients = this.clienteRepository.findAll();

        return ResponseEntity.ok(clients);
    }

    @GetMapping("/findClientById/{id}")
    public ResponseEntity<Cliente> findClientById(@PathVariable("id") Long idClient) {
        Optional<Cliente> clientOptional = this.clienteRepository.findById(idClient);

        return clientOptional
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/removeClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable("id") Long idClient){
        Optional<Cliente> clientOptional = this.clienteRepository.findById(idClient);

        clientOptional.ifPresent(this.clienteRepository::delete);
    }

    @PutMapping("/updateClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente){
        Optional<Cliente> clientOptional = this.clienteRepository.findById(id);

        clientOptional.ifPresent((c) -> {
            System.err.println("update");
            this.clienteRepository.save(cliente);
        });
    }
}

package mx.clientes.registro.controller_cliente

import mx.clientes.registro.dao_cliente.IClienteDAO
import mx.clientes.registro.modelos_clientes.Cliente
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class ClienteController {

    @Autowired
    @Qualifier("clienteDAOImpl")
    private lateinit var clienteDao: IClienteDAO

    @GetMapping("/clientes")
    fun listarClientes(vista: Model): String {
        vista.addAttribute("titulo", "Clientes registrados")
        vista.addAttribute("lista_clientes", this.clienteDao.clientes())
        return "clienteVistas/verClientes"
    }

    @GetMapping("/cliente_id/{id}")
    fun buscarClienteID(@PathVariable id: Long, vista: Model): String {
        vista.addAttribute("titulo", "Cliente registrados")
        vista.addAttribute("cliente", this.clienteDao.clienteID(id))

        return "clienteVistas/verClientes"
    }


    @GetMapping("/form", "")
    fun formRegistroCliente(vista: Model): String {
        val cliente = Cliente()
        vista.addAttribute("cliente", cliente)
        vista.addAttribute("titulo", "Formulario de Cliente")
        return "nuevoCliente/form"
    }


    @PostMapping("/saveCliente")
    fun procesoGuardar(cliente: Cliente): String {
        this.clienteDao.nuevoCliente(cliente)
        return "redirect:clientes"
    }


}
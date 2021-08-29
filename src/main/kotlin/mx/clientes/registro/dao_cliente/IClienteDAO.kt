package mx.clientes.registro.dao_cliente

import mx.clientes.registro.modelos_clientes.Cliente

interface IClienteDAO {
    fun clientes(): MutableList<Cliente>?
    fun nuevoCliente(cliente: Cliente?)
    fun clienteID(id: Long): Cliente?
}
package mx.clientes.registro.dao_cliente

import mx.clientes.registro.modelos_clientes.Cliente
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Suppress("UNCHECKED_CAST")
@Service
class ClienteDAOImpl : IClienteDAO {

    @PersistenceContext
    private var em: EntityManager? = null

    @Transactional(readOnly = true)
    override fun clientes(): MutableList<Cliente>? {
        return this.em?.createQuery("SELECT c FROM Cliente c")?.resultList as MutableList<Cliente>
    }

    @Transactional
    override fun nuevoCliente(cliente: Cliente?) {
        return cliente.let { em?.persist(it) }
    }

    @Transactional(readOnly = true)
    override fun clienteID(id: Long): Cliente? {
        /*
         val query: Query? = this.em?.createQuery("SELECT c FROM Cliente c WHERE c.idCliente = :id")
         query?.setParameter("id", id)

        return (query?.resultList as MutableList<Cliente>)[0]
         */

        return em?.find(Cliente::class.java, id)

    }
}
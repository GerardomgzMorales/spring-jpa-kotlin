package mx.clientes.registro.modelos_clientes

import org.springframework.format.annotation.DateTimeFormat
import java.io.Serializable
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Entity
@Table(name = "clientes")
class Cliente : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente", nullable = false)
    open var idCliente: Long? = null

    @NotEmpty
    @NotNull
    var nombre: String? = null

    @NotEmpty
    @NotNull
    var apellidos: String? = null

    @NotEmpty
    @NotNull
    @Column(unique = true, nullable = false)
    var correo: String? = null

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_registro_cliente", nullable = false, updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var fechaRegistro: Date? = null


}
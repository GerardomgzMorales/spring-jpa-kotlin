package mx.clientes.registro.modelos_clientes

import lombok.AllArgsConstructor
import lombok.Getter
import lombok.Setter
import org.springframework.format.annotation.DateTimeFormat
import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "clientes")
@AllArgsConstructor
@Setter
@Getter
class Cliente : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente", nullable = false)
    open var idCliente: Long? = null
    var nombre: String? = null
    var apellidos: String? = null

    @Column(unique = true, nullable = false)
    var correo: String? = null

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_registro_cliente", nullable = false, updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var fechaRegistro: Date? = null


}
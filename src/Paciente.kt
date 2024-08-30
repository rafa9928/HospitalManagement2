// Paciente.kt
class Paciente(
    dni: String,
    nombre: String,
    apellido: String,
    fechaNacimiento: String,
    direccion: String,
    ciudadProcedencia: String,
    val numeroHistoriaClinica: String,
    val sexo: String,
    val grupoSanguineo: String,
    val medicamentosAlergicos: List<String>
) : Persona(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia)


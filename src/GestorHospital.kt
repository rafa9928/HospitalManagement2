// GestorHospital.kt
class GestorHospital {
    private val pacientes = mutableListOf<Paciente>()
    private val medicos = mutableListOf<Medico>()
    private val empleados = mutableListOf<Empleado>()
    private val citas = mutableListOf<CitaMedica>()

    fun registrarPaciente(paciente: Paciente) {
        pacientes.add(paciente)
    }

    fun registrarMedico(medico: Medico) {
        medicos.add(medico)
    }

    fun registrarEmpleado(empleado: Empleado) {
        empleados.add(empleado)
    }

    fun registrarCitaMedica(cita: CitaMedica) {
        citas.add(cita)
    }

    fun listarMedicosPorEspecialidad(especialidad: String): List<Medico> {
        return medicos.filter { it.especialidad == especialidad }
    }

    fun listarPacientesPorMedico(codigoMedico: String): List<Paciente> {
        return citas.filter { it.medico.codigoEmpleado == codigoMedico }.map { it.paciente }
    }

    fun imprimirMedicos(medicos: List<Medico>) {
        if (medicos.isEmpty()) {
            println("No se encontraron médicos con esa especialidad.")
        } else {
            medicos.forEach { println("Médico: ${it.nombre} ${it.apellido}, Especialidad: ${it.especialidad}") }
        }
    }

    fun imprimirPacientes(pacientes: List<Paciente>) {
        if (pacientes.isEmpty()) {
            println("No se encontraron pacientes atendidos por ese médico.")
        } else {
            pacientes.forEach { println("Paciente: ${it.nombre} ${it.apellido}, Historia Clínica: ${it.numeroHistoriaClinica}") }
        }
    }

    fun solicitarDatosPaciente() {
        println("Ingrese DNI del paciente:")
        val dni = readLine()!!
        println("Ingrese nombre del paciente:")
        val nombre = readLine()!!
        println("Ingrese apellido del paciente:")
        val apellido = readLine()!!
        println("Ingrese fecha de nacimiento del paciente (dd/mm/yyyy):")
        val fechaNacimiento = readLine()!!
        println("Ingrese dirección del paciente:")
        val direccion = readLine()!!
        println("Ingrese ciudad de procedencia del paciente:")
        val ciudadProcedencia = readLine()!!
        println("Ingrese número de historia clínica del paciente:")
        val numeroHistoriaClinica = readLine()!!
        println("Ingrese sexo del paciente (M/F):")
        val sexo = readLine()!!
        println("Ingrese grupo sanguíneo del paciente:")
        val grupoSanguineo = readLine()!!
        println("Ingrese lista de medicamentos a los que es alérgico (separados por comas):")
        val medicamentosAlergicos = readLine()!!.split(",").map { it.trim() }

        val paciente = Paciente(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia, numeroHistoriaClinica, sexo, grupoSanguineo, medicamentosAlergicos)
        registrarPaciente(paciente)
    }

    fun solicitarDatosMedico() {
        println("Ingrese DNI del médico:")
        val dni = readLine()!!
        println("Ingrese nombre del médico:")
        val nombre = readLine()!!
        println("Ingrese apellido del médico:")
        val apellido = readLine()!!
        println("Ingrese fecha de nacimiento del médico (dd/mm/yyyy):")
        val fechaNacimiento = readLine()!!
        println("Ingrese dirección del médico:")
        val direccion = readLine()!!
        println("Ingrese ciudad de procedencia del médico:")
        val ciudadProcedencia = readLine()!!
        println("Ingrese código del empleado del médico:")
        val codigoEmpleado = readLine()!!
        println("Ingrese número de horas extras del médico:")
        val numeroHorasExtras = readLine()!!.toInt()
        println("Ingrese fecha de ingreso del médico (dd/mm/yyyy):")
        val fechaIngreso = readLine()!!
        println("Ingrese área del médico:")
        val area = readLine()!!
        println("Ingrese cargo del médico:")
        val cargo = readLine()!!
        println("Ingrese salario mensual del médico:")
        val salarioMensual = readLine()!!.toDouble()
        println("Ingrese porcentaje adicional por hora extra del médico:")
        val porcentajeAdicionalHoraExtra = readLine()!!.toDouble()
        println("Ingrese especialidad del médico:")
        val especialidad = readLine()!!
        println("Ingrese servicio del médico:")
        val servicio = readLine()!!
        println("Ingrese número de consultorio del médico:")
        val numeroConsultorio = readLine()!!.toInt()

        val medico = Medico(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia, codigoEmpleado, numeroHorasExtras, fechaIngreso, area, cargo, salarioMensual, porcentajeAdicionalHoraExtra, especialidad, servicio, numeroConsultorio)
        registrarMedico(medico)
    }

    fun solicitarDatosEmpleado() {
        println("Ingrese DNI del empleado:")
        val dni = readLine()!!
        println("Ingrese nombre del empleado:")
        val nombre = readLine()!!
        println("Ingrese apellido del empleado:")
        val apellido = readLine()!!
        println("Ingrese fecha de nacimiento del empleado (dd/mm/yyyy):")
        val fechaNacimiento = readLine()!!
        println("Ingrese dirección del empleado:")
        val direccion = readLine()!!
        println("Ingrese ciudad de procedencia del empleado:")
        val ciudadProcedencia = readLine()!!
        println("Ingrese código del empleado:")
        val codigoEmpleado = readLine()!!
        println("Ingrese número de horas extras del empleado:")
        val numeroHorasExtras = readLine()!!.toInt()
        println("Ingrese fecha de ingreso del empleado (dd/mm/yyyy):")
        val fechaIngreso = readLine()!!
        println("Ingrese área del empleado:")
        val area = readLine()!!
        println("Ingrese cargo del empleado:")
        val cargo = readLine()!!

        println("¿Es el empleado eventual? (s/n):")
        val esEventual = readLine()!!
        if (esEventual.equals("s", ignoreCase = true)) {
            println("Ingrese honorarios por hora del empleado eventual:")
            val honorariosPorHora = readLine()!!.toDouble()
            println("Ingrese número total de horas trabajadas del empleado eventual:")
            val horasTrabajadas = readLine()!!.toInt()
            println("Ingrese fecha de término del contrato del empleado eventual (dd/mm/yyyy):")
            val fechaTerminoContrato = readLine()!!
            val empleado = EmpleadoEventual(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia, codigoEmpleado, numeroHorasExtras, fechaIngreso, area, cargo, honorariosPorHora, horasTrabajadas, fechaTerminoContrato)
            registrarEmpleado(empleado)
        } else {
            println("Ingrese salario mensual del empleado por planilla:")
            val salarioMensual = readLine()!!.toDouble()
            println("Ingrese porcentaje adicional por hora extra del empleado por planilla:")
            val porcentajeAdicionalHoraExtra = readLine()!!.toDouble()
            val empleado = EmpleadoPorPlanilla(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia, codigoEmpleado, numeroHorasExtras, fechaIngreso, area, cargo, salarioMensual, porcentajeAdicionalHoraExtra)
            registrarEmpleado(empleado)
        }
    }

    fun solicitarDatosCitaMedica() {
        println("Ingrese DNI del paciente:")
        val dniPaciente = readLine()!!
        val paciente = pacientes.find { it.dni == dniPaciente } ?: run {
            println("Paciente no encontrado.")
            return
        }
        println("Ingrese código del médico:")
        val codigoMedico = readLine()!!
        val medico = medicos.find { it.codigoEmpleado == codigoMedico } ?: run {
            println("Médico no encontrado.")
            return
        }
        println("Ingrese código del empleado que atiende la cita:")
        val codigoEmpleado = readLine()!!
        val empleado = empleados.find { it.codigoEmpleado == codigoEmpleado } ?: run {
            println("Empleado no encontrado.")
            return
        }
        println("Ingrese fecha de la cita (dd/mm/yyyy):")
        val fecha = readLine()!!
        println("Ingrese hora de la cita (HH:mm):")
        val hora = readLine()!!

        val cita = CitaMedica(paciente, medico, empleado, fecha, hora)
        registrarCitaMedica(cita)
    }

    fun menu() {
        while (true) {
            println("\n--- Menú ---")
            println("1. Registrar paciente")
            println("2. Registrar médico")
            println("3. Registrar empleado")
            println("4. Registrar cita médica")
            println("5. Listar médicos por especialidad")
            println("6. Listar pacientes atendidos por un médico")
            println("0. Salir")
            println("Ingrese una opción:")

            when (readLine()!!) {
                "1" -> solicitarDatosPaciente()
                "2" -> solicitarDatosMedico()
                "3" -> solicitarDatosEmpleado()
                "4" -> solicitarDatosCitaMedica()
                "5" -> {
                    println("Ingrese especialidad para listar médicos:")
                    val especialidad = readLine()!!
                    val medicos = listarMedicosPorEspecialidad(especialidad)
                    imprimirMedicos(medicos)
                }
                "6" -> {
                    println("Ingrese código del médico para listar pacientes:")
                    val codigoMedico = readLine()!!
                    val pacientes = listarPacientesPorMedico(codigoMedico)
                    imprimirPacientes(pacientes)
                }
                "0" -> return
                else -> println("Opción inválida. Inténtelo de nuevo.")
            }
        }
    }
}

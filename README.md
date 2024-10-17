# MecaTask
Gestión de Tareas Talleres 
Descripción
Este proyecto es un sistema de gestión de tareas automotriz o taller en general que permite la asignación de tareas a técnicos sobre diferentes vehículos. Las tareas pueden estar en diferentes estados como "Recibido", "En Proceso"."Inspeccion" y "Terminado". El sistema utiliza la arquitectura Modelo-Vista-Controlador (MVC), y la interfaz gráfica está construida en Swing. Cuenta con roles de usuario, incluyendo administradores y técnicos.

Arquitectura
Este proyecto está basado en el patrón de diseño MVC:

Modelo: Maneja la lógica de negocio y el acceso a los datos. Contiene las clases Vehiculo, Tarea, Usuario, Tecnico, y sus respectivos DAOs para interactuar con la base de datos.
Vista: Utiliza Swing para la creación de la interfaz gráfica, donde los usuarios pueden interactuar con el sistema, ingresar datos y ver el progreso de las tareas.
Controlador: Conecta la vista con el modelo, gestionando los eventos y la lógica de aplicación.
Componentes de la Arquitectura
Modelo: Gestiona los datos y realiza las operaciones de negocio.
Clases como Vehiculo, Tarea, Usuario, y Tecnico.
Clases DAO (VehiculoDAO, TareaDAO, UsuarioDAO, etc.) para acceso a la base de datos.
Vista: Desarrollada en Swing, ofrece un conjunto de ventanas y formularios para la interacción del usuario.
Formularios para registrar vehículos, tareas, y técnicos.
Tablas para listar tareas, técnicos y vehículos.
Formularios de login para administradores y técnicos.
Controlador: Gestiona las acciones del usuario en la interfaz gráfica y realiza las actualizaciones correspondientes en el modelo.
Controladores para manejar eventos en las vistas (VehiculoController, TareaController, etc.).
Funcionalidades
Gestión de Vehículos: Registrar, listar, actualizar y eliminar vehículos.
Gestión de Técnicos: Registrar técnicos y asignarles tareas.
Gestión de Tareas: Asignar tareas a técnicos sobre vehículos específicos, modificar el estado de la tarea (Recibido, En Proceso, Terminado) y definir fechas de inicio y fin.
Roles de Usuario:
Administrador: Puede gestionar tareas, vehículos y técnicos.
Técnico: Solo puede visualizar y gestionar las tareas asignadas.
Requisitos Previos
Java 11+
MySQL
Maven
Git
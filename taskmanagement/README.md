# API RESTful - Task Management (NUEVO SPA)

API RESTful desarrollada para la empresa NUEVO SPA, orientada a la gestión de tareas con autenticación de usuarios mediante JWT.

## 🧰 Tecnologías utilizadas

- Java 17
- Spring Boot 3.4.x
- Spring Security con JWT
- Base de datos en memoria H2
- JPA (Hibernate)
- Maven
- OpenAPI 3.0 / Swagger UI
- Postman (colección incluida)

## 📁 Estructura del Proyecto

```bash
taskmanagement/
├── config/           # Configuración de seguridad y OpenAPI
├── controller/       # Controladores REST (Auth y Task)
├── dto/              # Clases de transferencia de datos (DTOs)
├── entity/           # Entidades JPA
├── repository/       # Interfaces de repositorio JPA
├── security/         # Filtro de autenticación JWT
├── service/          # Lógica de negocio
└── postman/          # Colección Postman para pruebas
```

## ⚙️ Configuración y ejecución

1. Clona el repositorio:

```bash
git clone https://github.com/salinaspedreros/desafio-spring-boot/tree/feature/moises_salinas
cd taskmanagement
```

2. Compila y ejecuta la aplicación con Maven:

```bash
mvn clean spring-boot:run
```

3. Accede a la documentación Swagger UI:

```
http://localhost:8080/swagger-ui/index.html
```

4. Accede al archivo OpenAPI (JSON):

```
http://localhost:8080/v3/api-docs
```

5. Accede a la consola H2 (base de datos en memoria):

```
http://localhost:8080/h2-console
```

**Parámetros de conexión H2:**
- **JDBC URL:** `jdbc:h2:mem:testdb`
- **Usuario:** `sa`
- **Contraseña:** (vacío)

## 🔐 Autenticación

Autenticación basada en JWT. Primero realiza login para obtener el token y luego úsalo en los demás endpoints como `Bearer <token>`.

### Usuario precargado (por defecto en H2):
- **email:** `admin@example.com`
- **password:** `admin`

## 🔁 Endpoints disponibles

| Método | Ruta              | Descripción                           |
|--------|-------------------|---------------------------------------|
| POST   | `/auth/login`     | Autenticación de usuario y token JWT  |
| GET    | `/tareas`         | Lista todas las tareas                |
| GET    | `/tareas/{id}`    | Obtiene una tarea por ID              |
| POST   | `/tareas`         | Crea una nueva tarea                  |
| PUT    | `/tareas/{id}`    | Actualiza una tarea existente         |
| DELETE | `/tareas/{id}`    | Elimina una tarea                     |

## 🧪 Pruebas con Postman

Se incluye una colección Postman ubicada en la carpeta `postman`:

```
postman/APITaskManagement.postman_collection.json
```

Importa esta colección en Postman para probar todos los endpoints, incluyendo login y uso de JWT.

## 🔧 Mejoras Sugeridas

- Logs de acceso y errores
- Manejo global de excepciones

## 👤 Autor

- Nombre: Moises Salinas
- Correo: salinas.pedreros@gmail.com
- Cargo: Desarrollador Java

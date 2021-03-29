# Configuración Inicial

## Prerrequisitos

-   Java 8
-   Docker

## Base de Datos

Obtener imagine mediante `docker pull`

```
docker pull postgres
```

Crear el contenedor mediante `docker-compose`

```
docker-compose up
```

Una vez realizado esto, se ejecuta el contenedor mediante `docker start`

```
docker start dan-ms-usuarios
```

Ejecutar el Maven Goal

```
./mvnw clean install
```

# Flyway

## Crear archivos de migración SQL

Para crear un archivo de migración se siguen las siguientes convenciones de nombres:

1. **Prefijo:** por defecto debe ser `V`.
2. **Version:** debe ser única. Puede contener tantos `.` y `_` como se quiera.
3. **Separador:** por defecto debe ser `__` (Dos guiones bajos).
4. **Descripcion:** texto separado por tantos `.` o `_` como se quiera.
5. **Sufijo:** debe ser `.sql`.

Entonces, un ejemplo de nombre de archivo de migración correcto es:

```
V1__CrearEntidadUsuario.sql
```

## Ejecutar migración

Luego de crear un archivo de migración, se debe ejecutar el Maven Goal

```
./mvnw flyway:migrate
```

## Deshacer una migración

Para deshacer una migración, se debe eliminar la fila correspondiente a esa versión de la tabla `flyway_schema_history`.

## Información adicional

-   [Configure Flyway with Spring Boot](https://medium.com/@tejozarkar/configure-flyway-with-spring-boot-9493aebf336b)
-   [Flyway Documentation](https://flywaydb.org/documentation/)

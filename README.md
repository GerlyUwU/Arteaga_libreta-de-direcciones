# Libreta de Direcciones

Este proyecto es una aplicación de consola que permite gestionar una libreta de direcciones. Ha sido desarrollado como parte del curso de Principios de Construcción de Software en la Facultad de Contaduría y Administración durante el período febrero – julio 2024.

## Objetivo y Resultados

El objetivo de este proyecto es desarrollar habilidades de Programación Orientada a Objetos (POO) mediante la creación de una solución modular y bien estructurada. La aplicación permite realizar operaciones como agregar, eliminar, buscar y mostrar entradas de direcciones. Los resultados esperados incluyen:

- Aplicar el principio "Divide and Conquer" usando modularidad y encapsulación.
- Desarrollar código con pruebas unitarias.
- Usar colecciones en Java para implementar estructuras de datos.
- Implementar el patrón Singleton para la clase `AddressBook`.
- Aplicar buenas prácticas para lograr código correcto, fácil de entender y mantenible.

## Clases

### address

- `AddressBookApplication`: Clase principal de la aplicación. Utiliza `Menu` y `AddressBook`.
- `Menu`: Clase para mostrar las opciones de menú al usuario.

### address.data

- `AddressBook`: Representa la libreta de direcciones, permitiendo operaciones de búsqueda, adición y eliminación de entradas.
- `AddressEntry`: Representa una sola entrada de información de contacto.

## Requisitos del Proyecto

### Funcionalidades

1. **Cargar entradas desde un archivo**: Permite al usuario cargar contactos desde un archivo de texto.
2. **Agregar entradas**: Solicita información al usuario para crear un nuevo `AddressEntry`.
3. **Eliminar entradas**: Permite buscar y eliminar un `AddressEntry`.
4. **Buscar entradas**: Permite buscar contactos por el inicio del apellido.
5. **Mostrar entradas**: Lista las direcciones en orden alfabético por apellido.
6. **Salir**: Finaliza la aplicación.

### Pruebas Unitarias

- Se debe crear una clase de prueba JUnit para cada clase.
- Las pruebas deben verificar los métodos de cada clase al menos dos veces.
- Las pruebas unitarias deben detectar errores introducidos en las clases correspondientes.

## Documentación y Diseño

- **Documentación JavaDoc**: Todas las clases, variables y métodos deben estar completamente documentados. La documentación JavaDoc debe ser accesible en GitHub.
- **Diagrama UML**: Se debe crear un diagrama de jerarquía de clases UML mostrando las relaciones y asociaciones entre objetos.

## Repositorio Git

- Se debe crear un repositorio Git local y un repositorio remoto en GitHub llamado `TuApellido_LibretaDirecciones`.
- Los commits deben estar bien comentados y se sugiere usar inglés para los comentarios.


## Enlaces Útiles

- [GitHub Commits Documentation](http://borg.csueastbay.edu/~grewe/CS401/Projects/GIthubCommits.html)
- [Documenting your project with wikis](https://docs.github.com/es/communities/documenting-your-project-with-wikis/about-wikis)

## Entregables

- Código publicado en GitHub.
- Documento o wiki en GitHub con la descripción detallada del sistema.
- URL de JavaDoc.
- Diagrama UML.
- Capturas de pantalla del sistema en funcionamiento.


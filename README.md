# zorro-post2-u12

## Descripción

Proyecto de ejemplo para pedidos que utiliza una arquitectura limpia con dominios, adaptadores y persistencia separada. Incluye validación arquitectónica con ArchUnit para garantizar las dependencias correctas entre paquetes.

## Ejecución

- Compilar y ejecutar pruebas:
  ```bash
  ./mvnw test
  ```
- Ejecutar solo la validación arquitectónica:
  ```bash
  ./mvnw test -Dtest=ReglasArquitectura
  ```

## Validación Arquitectónica

La validación arquitectónica se implementa en `src/test/java/com/empresa/pedidos/ReglasArquitectura.java` mediante ArchUnit. Las reglas definidas son:

1. **Dominio aislado**
   - Las clases del paquete `com.empresa.pedidos.dominio` no deben depender de `infraestructura`, `adaptadores`, `jakarta.persistence`, `javax.persistence`, `org.springframework` ni `org.springframework.mail`.

2. **Controladores solo acceden a la Facade**
   - Las clases del paquete `com.empresa.pedidos.adaptadores.rest` deben acceder únicamente a `com.empresa.pedidos.adaptadores.rest`, `com.empresa.pedidos.adaptadores.facade`, y paquetes de Spring/Web/HTTP/Java permitidos.

3. **Puertos de dominio son interfaces**
   - Las clases del paquete `com.empresa.pedidos.dominio.puertos` deben ser interfaces.

4. **Procesadores implementan ProcesadorPedido**
   - Las clases del paquete `com.empresa.pedidos.adaptadores.procesadores` deben implementar la interfaz `com.empresa.pedidos.dominio.puertos.ProcesadorPedido`, excluyendo las clases de fábrica y pruebas.

5. **Infraestructura no accede a adaptadores REST**
   - Las clases del paquete `com.empresa.pedidos.infraestructura` no deben acceder a `com.empresa.pedidos.adaptadores.rest`.

## Capturas

Las capturas de pantalla relacionadas con la validación arquitectónica y el pipeline se encuentran en la carpeta `docs` en la raíz del proyecto:

- ![Test aprobado pipeline](docs/Test%20aprovado%20pipeline.png)
- ![Test fallido pipeline](docs/Test%20fallido%20pipeline.png)


# 📊 Inventario de Activos

Este proyecto es un sistema de inventario y depreciación de activos desarrollado con Spring Boot, Java 17, Maven y H2 Database.

## 🚀 Despliegue Local

Sigue estos pasos para ejecutar el proyecto localmente:

1. **Clonar el repositorio de GitHub:**
    ```sh
    git clone https://github.com/tu-usuario/inventario-activos.git
    ```
2. **Navegar al directorio del proyecto:**
    ```sh
    cd inventario-activos
    ```
3. **Ejecutar el proyecto:**
    ```sh
    mvn spring-boot:run
    ```

## 🐳 Despliegue en Kubernetes

Para desplegar este proyecto en Kubernetes, sigue los pasos a continuación:

1. **Construir la imagen Docker:**
    ```sh
    docker build -t inventario-activos .
    ```
2. **Crear un archivo de despliegue para Kubernetes `deployment.yaml`:**
    ```yaml
    apiVersion: apps/v1
    kind: Deployment
    metadata:
      name: inventario-activos
    spec:
      replicas: 1
      selector:
        matchLabels:
          app: inventario-activos
      template:
        metadata:
          labels:
            app: inventario-activos
        spec:
          containers:
            - name: inventario-activos
              image: inventario-activos:latest
              ports:
                - containerPort: 8080
    ---
    apiVersion: v1
    kind: Service
    metadata:
      name: inventario-activos
    spec:
      selector:
        app: inventario-activos
      ports:
        - protocol: TCP
          port: 80
          targetPort: 8080
    ```
3. **Aplicar la configuración de Kubernetes:**
    ```sh
    kubectl apply -f deployment.yaml
    ```

## 📐 Diagramas

### 📋 Diagrama de Clases

![Diagrama de Clases](UBICADO EN LA CARPETA DIAGRAMAS DENTRO DEL PROYECTO)

### 🏗️ Diagrama de Componentes

![Diagrama de Componentes](UBICADO EN LA CARPETA DIAGRAMAS DENTRO DEL PROYECTO)

### 🔄 Diagrama de Secuencia

![UBICADO EN LA CARPETA DIAGRAMAS DENTRO DEL PROYECTO]()

## 📚 Documentación Adicional

### API Endpoints

#### Registrar un equipo

- **Método:** POST
- **URL:** `/api/equipos`
- **Cuerpo de la solicitud:**
    ```json
    {
      "numeroSerie": "12345",
      "descripcion": "Laptop de oficina",
      "nombre": "Laptop Dell",
      "fechaCompra": "2023-01-01",
      "valorCompra": 1200.0
    }
    ```

#### Obtener todos los equipos

- **Método:** GET
- **URL:** `/api/equipos`

#### Obtener un equipo por ID

- **Método:** GET
- **URL:** `/api/equipos/{id}`

#### Actualizar un equipo

- **Método:** PUT
- **URL:** `/api/equipos/{id}`
- **Cuerpo de la solicitud:**
    ```json
    {
      "numeroSerie": "12345",
      "descripcion": "Laptop de oficina actualizada",
      "nombre": "Laptop Dell",
      "fechaCompra": "2023-01-01",
      "valorCompra": 1100.0
    }
    ```

#### Eliminar un equipo

- **Método:** DELETE
- **URL:** `/api/equipos/{id}`

#### Calcular el valor depreciado de un equipo

- **Método:** GET
- **URL:** `/api/equipos/depreciacion/{id}/{anios}`

## 🔧 Tecnologías Utilizadas

- **Framework:** Spring Boot 3
- **Lenguaje:** Java 17
- **Build Tool:** Maven
- **Base de Datos:** H2 Database
- **Documentación API:** OpenAPI 3 con Swagger

## 🧪 Pruebas

Para ejecutar las pruebas unitarias, usa el siguiente comando:

```sh
mvn test

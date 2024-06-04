# Inventario de Activos

Este proyecto es un sistema de inventario y depreciación de activos desarrollado con Spring Boot, Java 17, Maven y H2 Database.

## Instrucciones para Despliegue Local

1. Clonar el repositorio de GitHub.
2. Ejecutar `mvn spring-boot:run`.

## Instrucciones para Despliegue en Kubernetes

1. Construir la imagen Docker:
    ```sh
    docker build -t inventario-activos .
    ```
2. Crear un archivo de despliegue para Kubernetes `deployment.yaml`:
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
3. Aplicar la configuración de Kubernetes:
    ```sh
    kubectl apply -f deployment.yaml
    ```

## Diagramas

### Diagrama de Clases

![Diagrama de Clases](link_to_class_diagram_image)

### Diagrama de Componentes

![Diagrama de Componentes](link_to_component_diagram_image)

### Diagrama de Secuencia

![Diagrama de Secuencia](link_to_sequence_diagram_image)

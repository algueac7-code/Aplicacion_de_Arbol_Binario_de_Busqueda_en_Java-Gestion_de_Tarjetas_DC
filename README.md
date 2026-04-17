# 🌳 Aplicación de Árbol Binario de Búsqueda en Java – Gestión de Tarjetas DC

## 📌 Descripción general

Este proyecto consiste en una aplicación de escritorio desarrollada en **Java Swing**, que implementa desde cero un **Árbol Binario de Búsqueda (ABB)** para gestionar una colección de tarjetas de DC Comics.

La aplicación permite insertar, buscar, eliminar, recorrer y visualizar los datos mediante una interfaz gráfica interactiva.

---

## 🚀 Funcionalidades

### 🔹 Inserción de tarjetas

* Inserción ordenada por ID dentro del ABB
* Validaciones:

  * ID único (verificado recorriendo el árbol)
  * ID entero positivo
  * Campos obligatorios (ID, descripción, categoría)

---

### 🔹 Búsqueda por ID

* Búsqueda mediante referencias de nodos
* Muestra toda la información de la tarjeta
* Resaltado visual del nodo encontrado en el árbol

---

### 🔹 Eliminación de nodos (reglas personalizadas)

La eliminación sigue reglas específicas:

* ✔ Nodo hoja → se elimina
* ✔ Nodo con solo subárbol izquierdo → se reemplaza
* ❌ Nodo con solo subárbol derecho → no se elimina
* ❌ Nodo con dos hijos → no se elimina
* ❌ Categoría "Civiles" → no se permite eliminar

---

### 🔹 Recorridos del árbol

* **PreOrden** → Raíz → Izquierda → Derecha
* **InOrden** → Izquierda → Raíz → Derecha *(ordenado)*
* **PostOrden** → Izquierda → Derecha → Raíz

Formato de salida:

```id="s2rkf8"
10 → 5 → 3 → 7 → 20
```

---

### 🔹 Análisis por categoría

* Conteo de nodos por categoría
* Enfocado en:

  * Súper héroes
  * Súper villanos
* Incluye cálculo de porcentajes

---

### 🔹 Listado de nodos hoja

Muestra las descripciones de las tarjetas que:

* Pertenecen a la categoría **"Frases icónicas"**
* Son nodos hoja (sin hijos)

---

### 🔹 Mayor y menor ID

* Identifica el nodo con menor ID
* Identifica el nodo con mayor ID
* Implementado mediante recorrido completo del árbol

---

### 🔹 Consulta adicional (integrada)

Incluye:

* Total de tarjetas de Súper héroes y Súper villanos
* Lista de frases icónicas que son nodos hoja
* Nodo con menor ID
* Nodo con mayor ID

---

### 🔹 Visualización del árbol

* Representación gráfica usando `JPanel`
* Nodos dibujados como círculos
* Conexiones padre-hijo
* Soporte de scroll para árboles grandes

---

## 🧠 Aspectos técnicos destacados

* Uso de **recursividad** en:

  * inserción
  * búsqueda
  * recorridos
  * consultas

* Implementación manual del ABB (sin estructuras predefinidas)

* Separación entre lógica y presentación

* Uso de Java Graphics para visualización

---

## 🖥️ Tecnologías utilizadas

* Java (JDK 23)
* Swing (Interfaz gráfica)
* Apache NetBeans
* Maven

---

## 📸 Capturas de pantalla

<img width="718" height="405" alt="image" src="https://github.com/user-attachments/assets/76712cb5-afbd-4422-a230-f54ad9b578c0" />

* Visualización del árbol
* Búsqueda con resaltado

<img width="718" height="407" alt="image" src="https://github.com/user-attachments/assets/840df870-4458-46fb-afbc-36f638a59978" />

* Recorridos
* Estadísticas por categoría

---

## 📂 Estructura del proyecto

```id="8m0m3m"
src/
├── Entidad/
│   └── Tarjeta.java
├── Logica/
│   ├── Nodo.java
│   └── Arbol.java
└── GUI/
    ├── General.java
    └── PanelArbol.java
```

---

## ⚙️ Ejecución

1. Clonar el repositorio:

```id="w6fw43"
git clone https://github.com/tu-usuario/tu-repositorio.git
```

2. Abrir en NetBeans o IDE compatible

3. Ejecutar la clase principal:

```id="4z4cnb"
com.mycompany.colecciontarjetas.ColeccionTarjetas
```

---

## 📌 Consideraciones

* Los datos se mantienen en memoria durante la ejecución
* No se utilizan estructuras de datos predefinidas
* Interfaz completamente gráfica (sin uso de consola ni cuadros de diálogo para resultados)

---

## 🎯 Objetivo del proyecto

Este proyecto demuestra:

* Comprensión de árboles binarios de búsqueda
* Uso práctico de recursividad
* Desarrollo de aplicaciones con interfaz gráfica
* Resolución de problemas mediante estructuras de datos

---

## 🧑‍💻 Autor

**Alonso Guevara Acosta**

---

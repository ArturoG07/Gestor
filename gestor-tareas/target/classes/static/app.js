document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('usuarioForm').addEventListener('submit', loginUsuario);
});

async function loginUsuario() {
        event.preventDefault();
        let nombre = document.getElementById('usuarioNombre').value;
        const response = await fetch("http://localhost:8080/api/usuarios/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                nombre: nombre,
                passwd: document.getElementById('usuarioContrasena').value
            })
        });

        const data = await response.json();
        if (data === true) {
            let id = await pedirID(nombre);
            cargarTareas(id);
        } else {
            console.log("Usuario o contraseña incorrectos");
        }
}
async function cargarTareas(id) {
    const response = await fetch(`http://localhost:8080/api/tareas/cargarTareas?id=${encodeURIComponent(id)}`, {
        method: "GET"
    })
    const data = await response.json();
    mostrarTareas(data);
}

async function pedirID(nombre) {
    const response = await fetch(`http://localhost:8080/api/usuarios/pedirId?nombre=${encodeURIComponent(nombre)}`, {
        method: "GET"
    });

    const data = await response.json();
    return data;
}
function mostrarTareas(tareas) {
    document.getElementById('usuarios').style.display = 'none';
    document.querySelector('main').style.display = 'block';
    const contenedor = document.getElementById('contenedorTareas');
    contenedor.innerHTML = '';

    tareas.forEach(tarea => {
        const div = document.createElement('div');
        div.classList.add('tarea');
        div.innerHTML = `
            <div class="tarea-header">
                <span class="tarea-id">#${tarea.id}</span>
                <span class="tarea-estado ${tarea.estadoTarea.toLowerCase()}">${tarea.estadoTarea}</span>
            </div>
            <h3 class="tarea-nombre">${tarea.nombre}</h3>
            <p class="tarea-desc">${tarea.descripcion}</p>
        `;
        contenedor.appendChild(div);
    });
}
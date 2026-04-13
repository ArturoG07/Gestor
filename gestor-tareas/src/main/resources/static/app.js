document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('login').addEventListener('click', loginUsuario);
});


async function loginUsuario() {
        event.preventDefault();
        let nombre = document.getElementById('inp-user').value;
        const response = await fetch("http://localhost:8080/api/usuarios/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                nombre: nombre,
                passwd: document.getElementById('inp-pass').value
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
    document.getElementById('view-usuario').style.display = 'block';
    document.getElementById('view-login').style.display = 'none';
    const contenedor = document.getElementById('contenedorTareas');
    contenedor.innerHTML = '';

    tareas.forEach(tarea => {
        const div = document.createElement('div');
        div.classList.add('task-card');
        div.innerHTML = `
            <div class="task-header">
                <span class="task-id">#${tarea.id}</span>
                <span class="badge-${tarea.estadoTarea.toLowerCase()}">${tarea.estadoTarea}</span>
            </div>
            <h3 class="task-name">${tarea.nombre}</h3>
            <p class="task-desc">${tarea.descripcion}</p>
        `;
        contenedor.appendChild(div);
    });
}
document.getElementById("añadirTarea").addEventListener("click", () => {
    document.getElementById("modal-add-tarea").classList.add("open");
});
document.getElementById("btn-cancelar-tarea").addEventListener("click", () => {
    document.getElementById("modal-add-tarea").classList.remove("open");
});
document.getElementById("btn-guardar-tarea").addEventListener("click", () => {
    if (camposTareaCorrectos()) {
        document.getElementById("modal-add-tarea").classList.remove("open");
        guardarTarea();
    } else {

    }
})
function camposTareaCorrectos() {
    let titulo = document.getElementById("tarea-titulo").value;
    let desc = document.getElementById("tarea-desc").value;
    let estado = document.getElementById("tarea-estado").value;
    if (titulo != null && desc != null && estado != null) {
        return true;
    } else {
        return false;
    }
}
async function guardarTarea() {
    let titulo = document.getElementById("tarea-titulo").value;
    let desc = document.getElementById("tarea-desc").value;
    let estado = document.getElementById("tarea-estado").value;
    const response = await fetch("http://localhost:8080/api/tareas/anadir", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            titulo: titulo,
            descripcion: desc,
            estado: estado,
        })
    });
}
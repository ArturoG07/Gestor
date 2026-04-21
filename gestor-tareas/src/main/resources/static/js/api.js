let data_usuario = { usuario: "", rol: "", email: "", nombre: "" };


async function cargarTareas() {
        const response = await fetch("http://localhost:8080/api/tareas/cargarTareas", {
            method: "GET",
            credentials: "include"
        });

        if (!response.ok) {
            const error = await response.text();
            console.log("Error:", error);
            return;
        }

        const data = await response.json();
        document.querySelectorAll(".task-card").forEach((element) => {
            element.addEventListener("click", detallesTarea);
        });
        mostrarTareas(filtrarTareas(data));
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
        credentials: "include",
        body: JSON.stringify({
            titulo: titulo,
            descripcion: desc,
            estado: estado,
        })
    });
    cargarTareas();
}
async function completarTarea() {
    const id = getIdTareaActual();
    if (!id) return;

    const card = document.querySelector(`.task-card[data-id="${id}"]`);
    const badge = card.querySelector('[class*="badge-"]');
    badge.className = 'badge badge-completada';
    badge.textContent = 'COMPLETADA';

    document.getElementById('modal-tarea-detail').classList.remove('open');
    const response = await fetch(`http://localhost:8080/api/tareas/completar`, {
        method: "PUT",
        credentials: "include",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ id_tarea: parseInt(id) })
    });

    if (!response.ok) {
        console.log("Error al actualizar la tarea");
        return;
    }
    cargarTareas();
}
async function borrarTarea() {
    const id = getIdTareaActual();
    if (!id) return;
    const card = document.querySelector(`.task-card[data-id="${id}"]`);
    const response = await fetch(`http://localhost:8080/api/tareas/eliminar`, {
        method: "DELETE",
        credentials: "include",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ id_tarea: parseInt(id) })
    });
    if (!response.ok) {
        console.log("Error al actualizar la tarea");
        return;
    }
    cargarTareas();
    document.getElementById('modal-tarea-detail').classList.remove('open');
    document.getElementById('modal-edit-tarea').classList.remove('open');
}

async function editarTarea() {
    const id = getIdTareaActual();
    if (!id) return;
    const newTitle = document.getElementById('tarea-tituloEdit').value;
    const newDesc = document.getElementById('tarea-descEdit').value;
    const newState = document.getElementById('tarea-estadoEdit').value
    const card = document.querySelector(`.task-card[data-id="${id}"]`);
    const response = await fetch(`http://localhost:8080/api/tareas/editar`, {
        method: "PUT",
        credentials: "include",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            id_tarea: parseInt(id),
            titulo: newTitle,
            descripcion: newDesc,
            estado: newState
        })
    })
    if (response.ok) {
        cargarTareas();
        document.getElementById('modal-tarea-detail').classList.remove('open');
        document.getElementById('modal-edit-tarea').classList.remove('open');
    } else {
        console.log("Error al actualizar la tarea");
    }
}

async function cargarDataUsuario() {
    const response = await fetch("http://localhost:8080/api/usuarios/data", {
        method: "GET",
        credentials: "include"
    });
    const data = await response.json();
    const usuario = data.nombre;
    const email = data.email;
    const nombre = data.nombre_completo;
    const rol = data.rol;
    data_usuario = { usuario, rol, nombre,email};
    mostrarDataUsuario();
}
function mostrarDataUsuario() {
    document.getElementById('perfil-usuario').textContent = data_usuario.usuario;
    document.getElementById('perfil-email').value = data_usuario.email;
    document.getElementById('perfil-nombre').value = data_usuario.nombre;
    document.getElementById('perfil-rol').textContent= `Rol: ${data_usuario.rol}`;
    document.getElementById('btn-save-perfil').disabled = true;
    document.querySelectorAll(".form-perfil input").forEach((element) => {
        element.addEventListener("input", () => {
            cambiarBotonModificacionPerfil();
        })
    })
    document.getElementById('perfil-passwd').value = "";
}
function cambiarBotonModificacionPerfil() {
    const email = document.getElementById('perfil-email').value;
    const nombre = document.getElementById('perfil-nombre').value;
    const passwd = document.getElementById('perfil-passwd').value;
    if (email !== data_usuario.email || nombre !== data_usuario.nombre || passwd !== "") {
        document.getElementById('btn-save-perfil').disabled = false;
    } else {
        document.getElementById('btn-save-perfil').disabled = true;
    }
}
async function actualizarDatos() {
    let new_nombre = document.getElementById('perfil-nombre').value;
    let new_email = document.getElementById('perfil-email').value;
    let new_passwd = document.getElementById('perfil-passwd').value;
    if (new_nombre == data_usuario.nombre) {
        new_nombre = "Default";
    }
    if (new_email == data_usuario.email) {
        new_email = "Default";
    }
    if (new_passwd == "") {
        new_passwd = "Default";
    }
    const response = await fetch(`http://localhost:8080/api/usuarios/update`, {
        method: "PUT",
        credentials: "include",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            new_nombre: new_nombre,
            new_email: new_email,
            new_passwd: new_passwd
        })
    })
    if (response.ok) {
        cargarDataUsuario();
    }
}
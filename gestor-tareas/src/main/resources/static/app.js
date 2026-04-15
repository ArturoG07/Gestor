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
    await mostrarTareas(data);
    document.querySelectorAll(".task-card").forEach((element) => {
        element.addEventListener("click", detallesTarea);
    })
}

function mostrarTareas(tareas) {
    document.getElementById('view-usuario').classList.add("active");
    document.getElementById('view-login').classList.remove("active");
    const contenedor = document.getElementById('user-tasks-grid');
    contenedor.innerHTML = '';

    tareas.forEach(tarea => {
        const div = document.createElement('div');
        div.classList.add('task-card');
        div.dataset.id = tarea.id;
        div.dataset.estado = tarea.estadoTarea;
        div.innerHTML = `
            <div class="task-card-header">
                <span class="task-id">#${tarea.id}</span>
                <span class="badge badge-${tarea.estadoTarea.toLowerCase()}">${tarea.estadoTarea.replace('_', ' ')}</span>
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
        credentials: "include",
        body: JSON.stringify({
            titulo: titulo,
            descripcion: desc,
            estado: estado,
        })
    });
    cargarTareas();
}
function cerrarSesion() {
    document.getElementById('view-usuario').classList.remove("active");
    document.getElementById('view-login').classList.add("active");
    document.getElementById('inp-user').value = "";
    document.getElementById('inp-pass').value = "";
}
function detallesTarea(event) {
    document.getElementById('modal-tarea-detail').classList.add("open");
    const card = event.target.closest('.task-card');
    const id          = card.querySelector('.task-id').textContent.replace('#', '').trim();
    const titulo      = card.querySelector('.task-name').textContent.trim();
    const descripcion = card.querySelector('.task-desc').textContent.trim();
    const estado      = card.querySelector('[class*="badge-"]').textContent.trim();
    document.getElementById('task-id').textContent = `Id: ${id}`;
    document.getElementById('task-title').textContent = `Titulo: ${titulo}`;
    document.getElementById('task-desc').textContent = `Descripcion: ${descripcion}`;
    document.getElementById('task-state').textContent = `${estado}`;
    document.querySelectorAll('.task-card').forEach(c => c.classList.remove('activeTask'));
    card.classList.add('activeTask');
}
document.getElementById("close-detail").addEventListener("click", () => {
    document.getElementById('modal-tarea-detail').classList.remove("open");
});
document.getElementById("btn-marcar-completada").addEventListener("click", completarTarea);
function getIdTareaActual() {
    return document.querySelector('.task-card.activeTask')?.dataset.id;
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
document.getElementById("edit-task").addEventListener("click", motrarEditor);
function motrarEditor() {
    const id = getIdTareaActual();
    const card = document.querySelector(`.task-card[data-id="${id}"]`);
    document.getElementById("modal-edit-tarea").classList.add("open");
    document.getElementById('tarea-tituloEdit').value = card.querySelector('.task-name').textContent;
    document.getElementById('tarea-descEdit').value = card.querySelector('.task-desc').textContent;
    document.getElementById('tarea-estadoEdit').value = card.dataset.estado.toUpperCase();
}
document.getElementById("btn-cancelar-edit").addEventListener("click", () => {
    document.getElementById("modal-edit-tarea").classList.remove("open");
})
document.getElementById("borrar-tarea").addEventListener("click", () => {
    borrarTarea();
})
document.getElementById("edit-tarea").addEventListener("click", editarTarea);
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
    } else {
        console.log("Error al actualizar la tarea");
    }
}
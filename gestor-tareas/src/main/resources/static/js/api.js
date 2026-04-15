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
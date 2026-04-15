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
    actualizarStats(tareas);
}
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
function getIdTareaActual() {
    return document.querySelector('.task-card.activeTask')?.dataset.id;
}
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
function actualizarStats(tareas) {
    const total = tareas.length;
    const pendientes = tareas.filter(t => t.estadoTarea === 'PENDIENTE').length;
    const enProceso = tareas.filter(t => t.estadoTarea === 'EN_PROCESO').length;
    const completadas = tareas.filter(t => t.estadoTarea === 'COMPLETADA').length;

    document.getElementById('u-stat-total').textContent = total;
    document.getElementById('u-stat-pending').textContent = pendientes;
    document.getElementById('u-stat-progress').textContent = enProceso;
    document.getElementById('u-stat-done').textContent = completadas;
}
function filtrarTareas(tareas) {
    const filtro = document.getElementById('user-filter-estado').value;
    if (filtro === 'todos') return tareas;
    return tareas.filter(t => t.estadoTarea.toLowerCase() === filtro);
}
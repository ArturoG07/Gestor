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
    }
});
document.getElementById("close-detail").addEventListener("click", () => {
    document.getElementById('modal-tarea-detail').classList.remove("open");
});
document.getElementById("btn-marcar-completada").addEventListener("click", completarTarea);
document.getElementById("edit-task").addEventListener("click", motrarEditor);
document.getElementById("edit-tarea").addEventListener("click", editarTarea);
document.getElementById('user-filter-estado').addEventListener('change', () => {
    cargarTareas();
});
    const tabTarea = document.getElementById("tab-tarea");
    const tabPerf = document.getElementById("tab-perf");
    const contenidoTareas = document.getElementById("tab-mis-tareas");
    const contenidoPerfil = document.getElementById("tab-perfil");

    tabTarea.addEventListener("click", () => {
    contenidoTareas.style.display = "block";
    contenidoPerfil.style.display = "none";

    tabTarea.classList.add("active");
    tabPerf.classList.remove("active");
});
    tabPerf.addEventListener("click", () => {
    contenidoTareas.style.display = "none";
    contenidoPerfil.style.display = "block";

    tabPerf.classList.add("active");
    tabTarea.classList.remove("active");
});
    document.getElementById("btn-save-perfil").addEventListener("click", () => {
        actualizarDatos();
    })
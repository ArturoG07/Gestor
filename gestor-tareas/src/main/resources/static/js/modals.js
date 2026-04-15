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
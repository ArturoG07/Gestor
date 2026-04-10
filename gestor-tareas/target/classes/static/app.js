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
    const data = await response.json()
    console.log(data);
}

async function pedirID(nombre) {
    const response = await fetch(`http://localhost:8080/api/usuarios/pedirId?nombre=${encodeURIComponent(nombre)}`, {
        method: "GET"
    });

    const data = await response.json();
    return data;
}
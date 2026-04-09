document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('usuarioForm').addEventListener('submit', loginUsuario);
});

async function loginUsuario() {
        event.preventDefault();
        const response = await fetch("http://localhost:8080/api/usuarios/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                nombre: document.getElementById('usuarioNombre').value,
                passwd: document.getElementById('usuarioContrasena').value
            })
        });

        const data = await response.json();

        if (data === true) {
            console.log("Login correcto");
        } else {
            console.log("Usuario o contraseña incorrectos");
        }
}

export function getPort() {
    return process.env.NODE_ENV === "production" ? 80 : 8080;
}


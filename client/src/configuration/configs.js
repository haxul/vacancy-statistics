export function getPort() {
    return process.env.NODE_ENV === "production" ? 80 : 8080;
}
export function getHost() {
    return process.env.NODE_ENV === "production" ? "82.148.29.161" : "localhost";

}
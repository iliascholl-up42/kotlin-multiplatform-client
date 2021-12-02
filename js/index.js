import client from "kotlin-multiplatform-client"

client.getId().then(res => res.data).then(console.log)

import requests
import hashlib
import base64
import json

# Definimos el contenido del documento
credential_subject = {
    "id": "did:dni:pe:10203040",
    "type": "Constancia de trabajo",
    "subjectName": "Juan Perez",
    "role": "Jefe de Planta",
    "startOfWork": "01/07/2018"
}

# Paso 2: Calcular hash SHA256
json_string = json.dumps(credential_subject, separators=(',', ':'), ensure_ascii=False)
evidence_hash = hashlib.sha256(json_string.encode('utf-8')).hexdigest()
base64_data = base64.b64encode(json_string.encode('utf-8')).decode()

# Paso 4: Llamada al API de Stamping.io
# Token proporcionado por Stamping.io
API_TOKEN = "98cdb8c28f159e8021b736173b9dbe8fa1d8a6d4bc68bf40f6448b05d7a"

# Construir URL
url = f"https://api.stamping.io/stamp/?evidence={evidence_hash}&data={base64_data}&async=true&token={API_TOKEN}"

# Ejecutar la petición
response = requests.get(url)

print("Status:", response.status_code)
print("Respuesta:", response.json())

#!/bin/bash

# Configurações de conexão
HOST="localhost"
DATABASE="/path/to/delivery.fdb"
USER="SYSDBA"
PASSWORD="123456"

# Função para executar o script SQL
execute_script() {
  isql -user $USER -password $PASSWORD $DATABASE <<EOF
    $1
EOF
}

execute_script "/create.sh"
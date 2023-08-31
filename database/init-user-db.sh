#!/bin/bash

set -e

psql -v ON_ERROR_STOP=1 --username WebappUser --dbname WebappDB <<-EOSQL
    GRANT ALL PRIVILEGES ON DATABASE WebappDB TO WebappUser;
EOSQL

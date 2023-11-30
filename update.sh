#!/bin/bash

# WARNING: PLEASE DO NOT MODIFY THIS SCRIPT. IF YOU DO, YOU MUST RUN THE COMMANDS MANUALLY TO REPULL THE GIT REPOSITORY SO THAT THE SCRIPT DOES NOT CHANGE AS IT EXECUTES. MAKE SURE TO SEND AN ALERT IF THIS HAS CHANGED!

echo "Updating and redeploying the IGE Backend (Script made by yours truly). If no changes are shown, please run: service nginx restart"
echo "----------------------------------------------------------------------------------------------------------------"
cd /root/IGE-backend-v2/
docker-compose down
git pull .
docker-compose up -d --build
echo "----------------------------------------------------------------------------------------------------------------"
echo "Update Complete. If no changes are shown, please run: service nginx restart. To check the server status, please run: service nginx status"

# Instructions

### Build
cmd -> cd <project_dir> -> gradle build

### Run
cmd -> cd <project_dir> -> gradle bootRun

### curl

- Add sample organization:

curl -H "Content-Type: application/json" -X POST -d "{\\"name\\":\\"Big Organization\\"}" http://localhost:8080/organization

- Add conference room for added organization:

curl -H "Content-Type: application/json" -X POST -d "{\\"name\\":\\"Conference Room\\",\\"identifier\\":\\"no.1\\",\\"level\\":0,\\"available\\":true,\\"standingCount\\":20,\\"seatsCount\\":10,\\"lyingCount\\":2,\\"hammockCount\\":1,\\"roomEquipment\\":{\\"projectorName\\":\\"Pansanonic9000\\",\\"hasPhone\\":true,\\"internalNumber\\":42,\\"externalNumber\\":\\"+12 123456789\\",\\"connectionInterface\\":\\"USB\\"}}" http://localhost:8080/room/organization/1

- Make reservation for added conference room:

curl -H "Content-Type: application/json" -X POST -d "{\\"clientId\\":\\"Mr. Muscle\\",\\"roomName\\":\\"Conference Room\\",\\"startDate\\":\\"04/01/2019 23:30\\",\\"endDate\\":\\"04/01/2019 23:59\\"}" http://localhost:8080/reservation

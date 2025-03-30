# Build project bằng Maven
mvn clean package

# Build Docker image
docker build -t springboot-app .

# Run Docker container
docker run -p 8080:8080 springboot-app
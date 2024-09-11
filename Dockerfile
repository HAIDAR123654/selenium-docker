# base image
FROM bellsoft/liberica-openjdk-alpine:17.0.8
# install curl jq
RUN apk add curl jq
# workspace in base base image
WORKDIR /home/selenium-docker
# Add the required files from this directory to base image directory
ADD target/docker-resources  ./
ADD runner.sh   runner.sh
#Environment Variables
# BROWSER
# HUB_HOST
# TEST_SUITE
# THREAD_COUNT
# Run the tests
#ENTRYPOINT java -cp 'libs/*' \
#           -Dselenium.grid.enabled=true \
#           -Dselenium.grid.hubHost=${HUB_HOST} \
#           -Dbrowser=${BROWSER} \
#           org.testng.TestNG \
#           -threadcount ${THREAD_COUNT} \
#           test-suites/${TEST_SUITE}
# fix for windows
RUN dos2unix runner.sh
# Start the runner.sh
ENTRYPOINT sh runner.sh


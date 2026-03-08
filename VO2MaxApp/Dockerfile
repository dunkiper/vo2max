FROM ubuntu:22.04

# Set environment variables
ENV ANDROID_SDK_ROOT=/android-sdk \
    PATH="${PATH}:/android-sdk/cmdline-tools/latest/bin:/android-sdk/emulator:/android-sdk/tools/bin:/android-sdk/platform-tools" \
    JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64

# Install dependencies
RUN apt-get update && apt-get install -y \
    git \
    openjdk-17-jdk \
    wget \
    unzip \
    curl \
    gradle \
    && rm -rf /var/lib/apt/lists/*

# Download and setup Android SDK
RUN mkdir -p ${ANDROID_SDK_ROOT} && \
    cd ${ANDROID_SDK_ROOT} && \
    wget -q https://dl.google.com/android/repository/commandlinetools-linux-9477386_latest.zip && \
    unzip -q commandlinetools-linux-9477386_latest.zip && \
    rm commandlinetools-linux-9477386_latest.zip && \
    mkdir -p cmdline-tools/latest && \
    mv cmdline-tools/* cmdline-tools/latest/ 2>/dev/null || true

# Accept SDK licenses and install required SDK packages
RUN yes | sdkmanager --sdk_root=${ANDROID_SDK_ROOT} --licenses && \
    sdkmanager --sdk_root=${ANDROID_SDK_ROOT} "platforms;android-21" "build-tools;33.0.1"

WORKDIR /app

# Build command
CMD ["/bin/bash", "-c", "gradle assembleDebug && cp app/build/outputs/apk/debug/app-debug.apk /app/"]

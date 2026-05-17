FROM python:3.11-slim

RUN apt-get update && apt-get install -y \
    openjdk-17-jre-headless \
    wget unzip curl \
    && rm -rf /var/lib/apt/lists/*

RUN wget -q https://github.com/skylot/jadx/releases/download/v1.5.0/jadx-1.5.0.zip \
    && unzip -q jadx-1.5.0.zip -d /opt/jadx \
    && rm jadx-1.5.0.zip \
    && chmod +x /opt/jadx/bin/jadx

ENV PATH="/opt/jadx/bin:$PATH"

WORKDIR /app

COPY backend/ ./
COPY .env ./

RUN pip install --no-cache-dir \
    flask \
    flask-cors \
    requests \
    python-dotenv

EXPOSE 5000

HEALTHCHECK --interval=30s --timeout=10s --start-period=15s \
    CMD curl -f http://localhost:5000/health || exit 1

CMD ["python", "app.py"]
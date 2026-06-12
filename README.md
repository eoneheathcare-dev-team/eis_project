# eis_project
EIS 백엔드 프로젝트

## Docker Compose 배포

```bash
docker compose up -d --build
```

서버 실행 프로파일은 `window`이며, 윈도우 서버 배포 설정은 `src/main/resources/application-window.yml`을 사용합니다.

포트나 DB 접속 정보를 바꿔야 하면 `.env.example`을 참고해서 `.env` 파일을 만들고 값을 수정합니다.

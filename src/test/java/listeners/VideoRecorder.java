package listeners;

import java.io.IOException;

/**
 * Класс для запуска и остановки захвата видео
 */
public class VideoRecorder {
    private Process process;

    public void startRecording(String filePath) throws IOException {
        // Команда для запуска FFmpeg (проверьте настройки вашего окружения)
        String command = String.format("ffmpeg -video_size 1920x1080 -framerate 30 -f x11grab -i :0.0 %s", filePath);
        process = Runtime.getRuntime().exec(command);
    }

    public void stopRecording() {
        if (process != null) {
            process.destroy(); // Остановка процесса записи
        }
    }
}

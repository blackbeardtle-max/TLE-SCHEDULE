using System.Diagnostics;

namespace TLEScheduleLauncher;

internal static class Program
{
    private const string WebUrl =
        "https://script.google.com/macros/s/AKfycbxzlIS5-PrPukc5DuIVRPoBtg0nT9rDfjF-27E50IC5qfveW6skVZ9eAUgZ0VS9ReA8/exec";

    [STAThread]
    private static void Main()
    {
        try
        {
            var edge = FindEdge();
            if (edge is not null)
            {
                Process.Start(new ProcessStartInfo
                {
                    FileName = edge,
                    Arguments = $"--app=\"{WebUrl}\" --start-maximized",
                    UseShellExecute = true
                });
                return;
            }

            Process.Start(new ProcessStartInfo
            {
                FileName = WebUrl,
                UseShellExecute = true
            });
        }
        catch
        {
            Process.Start(new ProcessStartInfo
            {
                FileName = WebUrl,
                UseShellExecute = true
            });
        }
    }

    private static string? FindEdge()
    {
        string[] candidates =
        {
            Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.ProgramFilesX86),
                "Microsoft", "Edge", "Application", "msedge.exe"),
            Path.Combine(Environment.GetFolderPath(Environment.SpecialFolder.ProgramFiles),
                "Microsoft", "Edge", "Application", "msedge.exe")
        };

        return candidates.FirstOrDefault(File.Exists);
    }
}

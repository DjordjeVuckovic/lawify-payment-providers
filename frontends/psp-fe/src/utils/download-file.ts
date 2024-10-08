export function downloadFile(fileName: string, blobFile: Blob) {
  const blob = new Blob([blobFile]);
  const downloadUrl = window.URL.createObjectURL(blob);
  const link = document.createElement('a');
  link.href = downloadUrl;
  link.download = fileName;
  link.click();
}
export function downloadFileUrl(blobFile: Blob): string  {
  const blob = new Blob([blobFile]);
  return window.URL.createObjectURL(blob);
}

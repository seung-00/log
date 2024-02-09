import {useRouteError} from "react-router-dom";

interface Error {
  statusText: string
  message: string
}

const isError = (error: unknown): error is Error => {
  if (!error) {
    return false
  }

  return error.hasOwnProperty("statusText") && error.hasOwnProperty("message")
}

const getErrorStatusText = (status?: number): string => {
  if (status === 404) {
    return "Not Found."
  }

  return "Sorry, an unexpected error has occurred."
}

type ErrorPageProps = {
  status?: number
}

export default function ErrorPage({status}: ErrorPageProps) {
  const error = useRouteError();
  console.error(error);

  return (
      <div id="error-page">
        <h1>Oops!</h1>
        <p>{getErrorStatusText(status)}</p>
        <p>
          {isError(error) && (
              <i>{error.statusText || error.message}</i>
          )}
        </p>
      </div>
  );
}
